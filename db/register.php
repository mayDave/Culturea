<?php
if(isset($_POST['email']) && isset($_POST['password'])){
    // Include i file necessari
    require_once "conn.php";
    require_once "validate.php";
    // Chiama la convalida, passa i dati del modulo come parametro e memorizza il valore restituito
    $email = validate($_POST['email']);
    $password = validate($_POST['password']);
    // Crea la stringa di query SQL. Useremo la funzione md5() per la sicurezza dei dati. Calcola e restituisce l'hash MD5 di una stringa
    $sql = "insert into users values('','$email', '" . md5($password) . "')";
    // Esegue la query. Stampa "successo" su un'esecuzione riuscita, altrimenti "fallimento".
    if(!$conn->query($sql)){
        echo "failure";
    }else{
        echo "success";   
    }
}
?>