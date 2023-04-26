<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class LivraisonFrontController extends AbstractController
{
    #[Route('/livraison/front', name: 'app_livraison_front')]
    public function index(): Response
    {
        return $this->render('livraison_front/index.html.twig', [
            'controller_name' => 'LivraisonFrontController',
        ]);
    }
}
