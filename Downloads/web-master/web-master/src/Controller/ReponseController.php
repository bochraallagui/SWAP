<?php

namespace App\Controller;

use App\Entity\Reponse;
use App\Form\ReponseType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Utils\BadwordFilter;
use Knp\Component\Pager\PaginatorInterface;
use Doctrine\Persistence\ManagerRegistry;




#[Route('/reponse')]
class ReponseController extends AbstractController
{
    #[Route('/', name: 'app_reponse_index', methods: ['GET'])]
    public function index(EntityManagerInterface $entityManager ,PaginatorInterface $paginator, Request $request): Response
    {
        $reponses = $entityManager
            ->getRepository(Reponse::class)
            ->findAll();
                
        // trier les réponses par messageRep
        usort($reponses, function($a, $b) {
            return strcmp($a->getMessageRep(), $b->getMessageRep());
        });
        
        // Utiliser le Paginator pour paginer les résultats
        $pagination = $paginator->paginate(
            $reponses,
            $request->query->getInt('page', 1),
            10
        );
    
        return $this->render('reponse/index.html.twig', [
            'pagination' => $pagination,
        ]);
    }
    
    
    #[Route('/new', name: 'app_reponse_new', methods: ['GET', 'POST'])]
public function new(Request $request, EntityManagerInterface $entityManager): Response
{
    $reponse = new Reponse();
    $form = $this->createForm(ReponseType::class, $reponse);
    $form->handleRequest($request);

    $badwordFilter = new BadwordFilter(['badwordone', 'badwordtwo', 'badwordthree']); // Replace with your list of badwords

    if ($form->isSubmitted() && $form->isValid()) {
        $message = $reponse->getMessageRep();
        if ($badwordFilter->hasBadword($message)) {
            return $this->redirectToRoute('app_reponse_index');

        } else {
            $entityManager->persist($reponse);
            $entityManager->flush();

            return $this->redirectToRoute('app_reponse_index');
        }
    }


    return $this->renderForm('reponse/new.html.twig', [
        'reponse' => $reponse,
        'form' => $form,
    ]);
}

    #[Route('/{idReponse}', name: 'app_reponse_show', methods: ['GET'])]
    public function show(Reponse $reponse,PaginatorInterface $paginator): Response
    {  // Utiliser le Paginator pour paginer les résultats
        $pagination = $paginator->paginate(
            $query,
            $request->query->getInt('page', 1),
            10
        );
        return $this->render('reponse/show.html.twig', [
            'reponse' => $reponse,
        ]);
    }

    #[Route('/{idReponse}/edit', name: 'app_reponse_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Reponse $reponse, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReponseType::class, $reponse);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_reponse_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reponse/edit.html.twig', [
            'reponse' => $reponse,
            'form' => $form,
        ]);
    }

    #[Route('/{idReponse}', name: 'app_reponse_delete', methods: ['POST'])]
    public function delete(Request $request, Reponse $reponse, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reponse->getIdReponse(), $request->request->get('_token'))) {
            $entityManager->remove($reponse);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_reponse_index', [], Response::HTTP_SEE_OTHER);
    }
    
   
   
 
    
    #[Route('/stat/stat', name: 'app_cons_stat', methods: ['GET'])]
   
    public function yourAction(EntityManagerInterface $entityManager)
    {
        $total = 0;
        $en_cours = 0;
        $validé= 0;
        $annulé = 0;
        
        $reponses = $entityManager->createQuery("SELECT r FROM App\Entity\Reponse r")->getResult();
        foreach ($reponses as $reponse) {
            $etat = $reponse->getEtat();
            switch ($etat) {
                case "en cours":
                    $en_cours++;
                    break;
                case "validé":
                    $validé++;
                    break;
                case "annulé":
                    $annulé++;
                    break;
            }
            $total++;
        }
        
        $pour_en_cours = ($en_cours * 100) / $total;
        $pour_validé = ($validé * 100) / $total;
        $pour_annulé = ($annulé * 100) / $total;
        
        $data = array(
            'en_cours' => $pour_en_cours,
            'validé' => $pour_validé,
            'annulé' => $pour_annulé
        );
        
        return $this->render('reponse/stat.html.twig', [
            'data' => $data,
        ]);
    }
    
}
