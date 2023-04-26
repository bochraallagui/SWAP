<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ServiceFrontController extends AbstractController
{
    #[Route('/service/front', name: 'app_service_front')]
    public function index(): Response
    {
        return $this->render('service_front/index.html.twig', [
            'controller_name' => 'ServiceFrontController',
        ]);
    }
}
