<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class CategorieFrontController extends AbstractController
{
    #[Route('/categorie/front', name: 'app_categorie_front')]
    public function index(): Response
    {
        return $this->render('categorie_front/index.html.twig', [
            'controller_name' => 'CategorieFrontController',
        ]);
    }
}
