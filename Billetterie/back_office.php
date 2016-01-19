<?php
    ini_set('session.save_path', 'tmp');
    session_start();
    function Connect_db(){
		$host="iutdoua-webetu.univ-lyon1.fr"; 
		$user="p1405029";     
		$password="213866";     
		$dbname="p1405029";
		
		try {
		    $bdd=new PDO('mysql:host='.$host.';dbname='.$dbname.';charset=utf8',$user,$password);
		    return $bdd;
		}
		catch (Exception $e) {
		    die('Erreur : '.$e->GETMessage());
		}  
	}

    $bdd = Connect_db();
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style_back.css" type="text/css">
        <?php
            //INITIALISATION
            if (isset($_GET['date_reservation'])){
                $date_reservation = $_GET['date_reservation'];
            }
            if (isset($_GET['zone'])){
                $zone = $_GET['zone'];
            }
            if (isset($_GET['court'])){
                $court = $_GET['court'];
            }
            if (isset($_GET['nouveau_nb'])){
                $nouveau_nb = $_GET['nouveau_nb'];  
            }
            if (isset($_GET['place'])){
                $place = $_GET['place'];  
            }
            if (isset($_GET['changement'])){
                $changement = 'true'; 
            } else {
                $changement = 'false';
            }
?>
    </head>
    <body>

<form method="GET" action="back_office.php" id = "formulaire">
                  	
              
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" min="2016-03-05" max="2016-03-13" value=<?php echo $date_reservation; ?>>
         		
                                            
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                         <?php
                            require_once("select_court.php");
                        ?>
                        </select>
						
						<p> Zone : </p>
                        <select name="zone" form = "formulaire">
                        <?php
                            require_once("select_zone.php");
                        ?>
						</select>
              

						<p> Type de place : </p>
                        <select name="place" form = "formulaire">
                            <?php
                                require_once("select_type.php");
                            ?>
                        </select>
                        <p>Nouveau nombre de places : </p>
                                <input type="number" 
                                       name="nouveau_nb" 
                                       id="nouveau_nb" 
                                       min="1" 
                                       value=<?php echo $nouveau_nb; ?>     
                                       ></br></br>
                        <input type="submit" value="Calculer nombre de places actuel" id="OK" >
                        <?php
                            if (isset($date_reservation) && isset($zone) && isset($court)){
                                $stmt = $bdd->prepare("SELECT ZONE FROM TABLE_ZONE WHERE BLOC = '".$_GET['zone']."'");
                                $stmt->execute();
                                while($bddZone = $stmt->fetch(PDO:: FETCH_ASSOC)){
                                    $zone_bloc = $bddZone['ZONE'];
                                }
                                
                                $stmt = $bdd->prepare("SELECT DISPO FROM BILLETS WHERE TYPE = '".$place."' AND DATE = '".$date_reservation."' AND ZONE = '".$zone_bloc."' AND COURT = '".$court."'");
                                $stmt->execute();
                                while($bddNbPlaces = $stmt->fetch(PDO:: FETCH_ASSOC)){
                                    $nb_places_restantes = $bddNbPlaces['DISPO'];
                                }
                                
                        ?>
                                
                        </form>
                                <p>Nombre de places actuel : <?php echo $nb_places_restantes ?> </p>
                                                
                        <?php
                            echo'<a href=back_office.php?date_reservation='.$_GET['date_reservation'].'&zone='.$zone.'&court='.$_GET['court'].'&zone_bloc='.$zone_bloc.'&place='.$_GET['place'].'&nouveau_nb='.$nouveau_nb.'&changement=true>Validation</a></br>';
                                if ($changement == 'true' && isset($nouveau_nb)){
                                    
                                        $stmt = "UPDATE `BILLETS` SET `TOTAL`=".$nouveau_nb." WHERE DATE='".$date_reservation."' AND COURT='".$court."' AND ZONE='".$_GET['zone_bloc']."' AND TYPE='".$place."';";
                                    if (!empty($nouveau_nb)){
                                    ?>
                                        <p>Commande à rentrer dans PhpMyAdmin :</p></br>
                                    <?php
                                        echo $stmt;
                                    } else {
                                    ?>
                                        <p class="echec">Merci d'indiquer une nouvelle quantité</p></br>
                                    <?php
                                }
                        } else {
                        ?>
                            <p class="erreur">Merci de remplir le formulaire</p>
                        <?php
                        }
                            }

                            $bdd->connection = null;
                        ?>  
</body>
</html>