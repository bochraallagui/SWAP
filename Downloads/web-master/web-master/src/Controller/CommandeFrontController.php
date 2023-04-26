<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class CommandeFrontController extends AbstractController
{
    #[Route('/commande/front', name: 'app_commande_front')]
    public function index(): Response
    {
        return $this->render('commande_front/index.html.twig', [
            'controller_name' => 'CommandeFrontController',
        ]);
    }
}
