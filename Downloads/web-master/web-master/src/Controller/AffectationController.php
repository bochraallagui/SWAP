<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AffectationController extends AbstractController
{
    #[Route('/affectation', name: 'app_affectation')]
    public function index(): Response
    {
        return $this->render('affectation/index.html.twig', [
            'controller_name' => 'AffectationController',
        ]);
    }
}
