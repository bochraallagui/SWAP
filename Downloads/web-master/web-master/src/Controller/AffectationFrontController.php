<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AffectationFrontController extends AbstractController
{
    #[Route('/affectation/front', name: 'app_affectation_front')]
    public function index(): Response
    {
        return $this->render('affectation_front/index.html.twig', [
            'controller_name' => 'AffectationFrontController',
        ]);
    }
}
