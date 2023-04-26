<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class PointderelaisController extends AbstractController
{
    #[Route('/pointderelais', name: 'app_pointderelais')]
    public function index(): Response
    {
        return $this->render('pointderelais/index.html.twig', [
            'controller_name' => 'PointderelaisController',
        ]);
    }
}
