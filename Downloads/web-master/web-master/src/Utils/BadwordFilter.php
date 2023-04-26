<?php



namespace App\Utils;

class BadwordFilter
{
    private $badwords;

    public function __construct(array $badwords)
    {
        $this->badwords = $badwords;
    }

    public function hasBadword(string $message): bool
    {
        foreach ($this->badwords as $badword) {
            if (strpos($message, $badword) !== false) {
                return true;
            }
        }

        return false;
    }
}

