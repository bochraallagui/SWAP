<?php

namespace App\Entity;
use App\Repository\ReclamationRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="IDX_CE6064048D9D2B1", columns={"fk_id_utilisateur"})})
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_rec", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idRec;
    #[Assert\Length(min: 3, minMessage: "Le champ objectif doit contenir au moins 3 caractères")]
    /**
     * @var string
     *
     * @ORM\Column(name="objectif", type="string", length=255, nullable=false)
     */
    
    private $objectif;
    
    /**
     * @var string
     *
     * @ORM\Column(name="text", type="string", length=255, nullable=false)
     * * @Assert\Length(min=10, minMessage="Le champ texte doit contenir au moins {{ limit }} caractères")
     */
   
    private $text;

    #[ORM\ManyToOne(inversedBy: 'reclamations')]

    private ?User $fkIdUtilisateur = null;
    
    

    public function getIdRec(): ?int
    {
        return $this->idRec;
    }

    public function getObjectif(): ?string
    {
        return $this->objectif;
    }

    public function setObjectif(string $objectif): self
    {
        $this->objectif = $objectif;

        return $this;
    }

    public function getText(): ?string
    {
        return $this->text;
    }

    public function setText(string $text): self
    {
        $this->text = $text;

        return $this;
    }

    public function getFkIdUtilisateur(): ?User
    {
        return $this->fkIdUtilisateur;
    }

    public function setFkIdUtilisateur(?User $fkIdUtilisateur): self
    {
        $this->fkIdUtilisateur = $fkIdUtilisateur;

        return $this;
    }


}
