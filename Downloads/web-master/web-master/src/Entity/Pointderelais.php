<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Pointderelais
 *
 * @ORM\Table(name="pointderelais", indexes={@ORM\Index(name="fk_id_livraisonp", columns={"fk_id_livraisonp"})})
 * @ORM\Entity
 */
class Pointderelais
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_pointderelais", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idPointderelais;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse_pointderelais", type="string", length=255, nullable=false)
     */
    private $adressePointderelais;

    /**
     * @var string
     *
     * @ORM\Column(name="region", type="string", length=255, nullable=false)
     */
    private $region;

    /**
     * @var int
     *
     * @ORM\Column(name="horaire", type="integer", nullable=false)
     */
    private $horaire;

    /**
     * @var int
     *
     * @ORM\Column(name="fk_id_livraisonp", type="integer", nullable=false)
     */
    private $fkIdLivraisonp;

    public function getIdPointderelais(): ?int
    {
        return $this->idPointderelais;
    }

    public function getAdressePointderelais(): ?string
    {
        return $this->adressePointderelais;
    }

    public function setAdressePointderelais(string $adressePointderelais): self
    {
        $this->adressePointderelais = $adressePointderelais;

        return $this;
    }

    public function getRegion(): ?string
    {
        return $this->region;
    }

    public function setRegion(string $region): self
    {
        $this->region = $region;

        return $this;
    }

    public function getHoraire(): ?int
    {
        return $this->horaire;
    }

    public function setHoraire(int $horaire): self
    {
        $this->horaire = $horaire;

        return $this;
    }

    public function getFkIdLivraisonp(): ?int
    {
        return $this->fkIdLivraisonp;
    }

    public function setFkIdLivraisonp(int $fkIdLivraisonp): self
    {
        $this->fkIdLivraisonp = $fkIdLivraisonp;

        return $this;
    }


}
