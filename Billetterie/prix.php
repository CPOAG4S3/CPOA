<?php

/*ZONE FROM BLOC (Haut, bas)*/
$st_bloc = $dbh->prepare("SELECT ZONE FROM TABLE_ZONE where BLOC = ?");
if ($st_bloc->execute(array($_GET['zone']))) {
  while ($row_bloc = $st_bloc->fetch()) {
    print_r($row_bloc);
  }
}

/* PROMO TYPE COEF*/
$st_promo = $dbh->prepare("SELECT COEF FROM REDUCTION where PROMO = ?");
if ($st_promo->execute(array($_GET['promo']))) {
  while ($row_promo = $st_promo->fetch()) {
    print_r($row_promo);
  }
}





/* PROMO ZONE COEF*/
$st_zone = $dbh->prepare("SELECT COEF FROM REDUCTION where PROMO = ?");
if ($st_zone->execute(array($row_bloc))) {
  while ($row_zone = $st_zone->fetch()) {
    print_r($row_zone);
  }
}

/* PROMO DATE COEF*/
$st_date = $dbh->prepare("SELECT COEF FROM REDUCTION_DATE where DATE = ?");
if ($st_date->execute(array($_GET['date']))) {
  while ($row_date = $st_date->fetch()) {
    print_r($row_date);
  }
}

$prix = 20 * $row_date * $row_zone;

if ($st_promo == 'Licencie' || $st_promo == 'Solidarite'){	$prix = $prix * $row_promo;}


$prix = $prix * ($_GET['nb_places']; 

?>



