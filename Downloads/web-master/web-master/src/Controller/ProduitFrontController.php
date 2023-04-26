<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ProduitFrontController extends AbstractController
{
    #[Route('/produit/front', name: 'app_produit_front')]
    public function index(): Response
    {
        return $this->render('produit_front/index.html.twig', [
            'controller_name' => 'ProduitFrontController',
        ]);
    }
}
