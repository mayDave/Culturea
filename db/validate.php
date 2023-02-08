<?php
function validate($data) {
 // Rimuovi i caratteri non necessari, ad esempio spazio extra, tabulazione, nuova riga dall'input dell'utente
  $data = trim($data);
  // Rimuovi backslashes    
  $data = stripslashes($data);
  // Converte i caratteri speciali in entità HTML, impedendo così agli aggressori di sfruttare il codice
  $data = htmlspecialchars($data);
  // Restituisce i dati convalidati
  return $data;
}
?>