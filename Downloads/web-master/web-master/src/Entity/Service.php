<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Service
 *
 * @ORM\Table(name="service")
 * @ORM\Entity
 */
class Service
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="description_service", type="string", length=255, nullable=false)
     */
    private $descriptionService;

    /**
     * @var string
     *
     * @ORM\Column(name="type_paiement_service", type="string", length=255, nullable=false)
     */
    private $typePaiementService;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDescriptionService(): ?string
    {
        return $this->descriptionService;
    }

    public function setDescriptionService(string $descriptionService): self
    {
        $this->descriptionService = $descriptionService;

        return $this;
    }

    public function getTypePaiementService(): ?string
    {
        return $this->typePaiementService;
    }

    public function setTypePaiementService(string $typePaiementService): self
    {
        $this->typePaiementService = $typePaiementService;

        return $this;
    }


}
