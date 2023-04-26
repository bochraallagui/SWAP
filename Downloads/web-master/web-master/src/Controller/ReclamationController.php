<?php

namespace App\Controller;
use App\Repository\ReclamationRepository;
use App\Entity\Reclamation;
use App\Form\ReclamationType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;


class ReclamationController extends AbstractController
{#[Route('/reclamation/back/', name: 'app_reclamation_index', methods: ['GET'])]
    public function index(ReclamationRepository $reclamationRepository): Response
    {
        return $this->render('reclamation/index.html.twig', [
            'reclamations' => $reclamationRepository->findAll(),
        ]);
    }
    #[Route('/search', name: 'app_reclamation_search', methods: ['GET'])]

    public function search(Request $request, EntityManagerInterface $entityManager): Response
    {
        $searchTerm = $request->query->get('q');
    
        $reclamations = $entityManager
            ->getRepository(Reclamation::class)
            ->createQueryBuilder('r')
            ->where('r.objectif LIKE :searchTerm OR r.idRec LIKE :searchTerm')
            ->setParameter('searchTerm', '%' . $searchTerm . '%')
            ->getQuery()
            ->getResult();
    
        return $this->render('reclamation/search.html.twig', [
            'reclamations' => $reclamations,
            'searchTerm' => $searchTerm,
        ]);
    }
    
}