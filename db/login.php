<?php
// Controlla se email e password sono impostate
if(isset($_POST['email']) && isset($_POST['password'])){
   // Include i file necessari
    require_once "conn.php";
    require_once "validate.php";
    // Chiama la convalida, passa i dati del modulo come parametro e memorizza il valore restituito
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
// Crea la stringa di query SQL
    $sql = "select * from users where email='$email' and password='" . md5($password) . "'";
// Esegue la query
    $result = $conn->query($sql);
    // Se il numero di righe restituite è maggiore di 0 (ovvero, se il record viene trovato), stamperemo "successo", altrimenti "fallimento"
    if($result->num_rows > 0){
        echo "success";
    } else{
        // Se non viene trovato alcun record, stampa "fallimento"
        echo "failure";
    }
}
?>