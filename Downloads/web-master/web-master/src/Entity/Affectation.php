<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Affectation
 *
 * @ORM\Table(name="affectation", indexes={@ORM\Index(name="fk_id_commande", columns={"fk_id_commande"}), @ORM\Index(name="fk_id_produit", columns={"fk_id_produit"})})
 * @ORM\Entity
 */
class Affectation
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_affectation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAffectation;

    /**
     * @var int
     *
     * @ORM\Column(name="fk_id_produit", type="integer", nullable=false)
     */
    private $fkIdProduit;

    /**
     * @var int
     *
     * @ORM\Column(name="fk_id_commande", type="integer", nullable=false)
     */
    private $fkIdCommande;

    public function getIdAffectation(): ?int
    {
        return $this->idAffectation;
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

    public function getFkIdCommande(): ?int
    {
        return $this->fkIdCommande;
    }

    public function setFkIdCommande(int $fkIdCommande): self
    {
        $this->fkIdCommande = $fkIdCommande;

        return $this;
    }


}
