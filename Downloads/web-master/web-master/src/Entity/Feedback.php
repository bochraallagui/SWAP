<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Feedback
 *
 * @ORM\Table(name="feedback", indexes={@ORM\Index(name="fk_id_produit", columns={"fk_id_produit"}), @ORM\Index(name="fk_id_userP", columns={"fk_id_userP"})})
 * @ORM\Entity
 */
class Feedback
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_feedbackP", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idFeedbackp;

    /**
     * @var bool
     *
     * @ORM\Column(name="favorisP", type="boolean", nullable=false)
     */
    private $favorisp;

    /**
     * @var int
     *
     * @ORM\Column(name="fk_id_userP", type="integer", nullable=false)
     */
    private $fkIdUserp;

    /**
     * @var int
     *
     * @ORM\Column(name="fk_id_produit", type="integer", nullable=false)
     */
    private $fkIdProduit;

    public function getIdFeedbackp(): ?int
    {
        return $this->idFeedbackp;
    }

    public function isFavorisp(): ?bool
    {
        return $this->favorisp;
    }

    public function setFavorisp(bool $favorisp): self
    {
        $this->favorisp = $favorisp;

        return $this;
    }

    public function getFkIdUserp(): ?int
    {
        return $this->fkIdUserp;
    }

    public function setFkIdUserp(int $fkIdUserp): self
    {
        $this->fkIdUserp = $fkIdUserp;

        return $this;
    }

    public function getFkIdProduit(): ?int
    {
        return $this->fkIdProduit;
    }

    public function setFkIdProduit(int $fkIdProduit): self
    {
        $this->fkIdProduit = $fkIdProduit;

        return $this;
    }


}
