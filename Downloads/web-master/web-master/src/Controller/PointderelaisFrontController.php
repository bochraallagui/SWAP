<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PointderelaisFrontController extends AbstractController
{
    #[Route('/pointderelais/front', name: 'app_pointderelais_front')]
    public function index(): Response
    {
        return $this->render('pointderelais_front/index.html.twig', [
            'controller_name' => 'PointderelaisFrontController',
        ]);
    }
}
