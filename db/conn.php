<?php
// Crea 4 variabili per memorizzare queste informazioni
$server="localhost";
$username="root";
$password="";
$database = "register_from_android";
// Crea connessione
$conn = new mysqli($server, $username, $password, $database);
// Controlla la connessione
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
?<
