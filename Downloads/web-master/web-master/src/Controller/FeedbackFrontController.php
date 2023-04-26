<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FeedbackFrontController extends AbstractController
{
    #[Route('/feedback/front', name: 'app_feedback_front')]
    public function index(): Response
    {
        return $this->render('feedback_front/index.html.twig', [
            'controller_name' => 'FeedbackFrontController',
        ]);
    }
}
