<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class UserFrontController extends AbstractController
{
    #[Route('/user/front', name: 'app_user_front')]
    public function index(): Response
    {
        return $this->render('user_front/index.html.twig', [
            'controller_name' => 'UserFrontController',
        ]);
    }
}
