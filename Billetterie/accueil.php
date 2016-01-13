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
		    die('Erreur : '.$e->getMessage());
		}  
	}
	
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="style.css" type="text/css">
        <?php
            $nom = $_GET['nom'];
            $prenom = $_GET['prenom'];	
            $date_reservation = $_GET['date_reservation'];			
            $mail = $_GET['mail'];
            $zone = $_GET['zone'];
            $court = $_GET['court'];
            $datenaiss = $_GET['datenaiss'];
            $nb_places = $_GET['nb_places'];
            $code_promo = $_GET['code_promo'];
        ?>
    </head>


    <body>
        <form method="get" action="accueil.php" id = "formulaire">
            <table>
                <tr> 
                    <td> 
                        <p>Nom : </p><input type="text" name="nom" value =<?php echo $nom; ?>>       
                    </td> 	
                    <td rowspan=4>	
                        <img src="./Images/plan_court.jpg" alt="Plan des courts">
                    </td>				
                    <td>
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" value=<?php echo $date_reservation; ?>>
                    </td>			
                </tr>

                <tr> 
                    <td> 
                        <p>Prénom : </p> <input type="text" name="prenom" value = <?php echo $prenom; ?>>
                    </td>
                    <td> 
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                        <option selected="selected">Court</option>
                        <option value = "Court1"> Court 1 </option>
                        <option value = "Court2"> Court 2 </option>
                        <option value = "Court3"> Court 3 </option>
                        <option value = "Court4"> Court 4 </option>
                        <option value = "Court5"> Court 5 </option>
                        <option value = "Court6"> Court 6 </option> 
                        </select>
                    </td>
                </tr>		


                <tr> 
                    <td>
                        <p>Date de naissance : </p> <input type="date" name="datenaiss" id="datenaiss" value=<?php echo $datenaiss; ?>>
                    </td>								
                    <td> 
                        <p> Zone : </p>
                        <select name="zone" form = "formulaire" >
                        <option selected="selected">Zone</option>
                        <option value = "A"> A </option>
                        <option value = "B"> B </option>
                        <option value = "C"> C </option>
                        <option value = "D"> D </option>
                        <option value = "E"> E </option>
                        <option value = "F"> F </option>
                        <option value = "G"> G </option>
                        <option value = "H"> H </option>
                        <option value = "I"> I </option>
                        <option value = "J"> J </option>
                        <option value = "K"> K </option>
                        <option value = "L"> L </option>
                        </select>
                    </td>
                </tr>	


                <tr>	
                    <td> 
                        <p>Mail : </p><input type="email" name="mail" value=<?php echo $mail; ?>>
                    </td>
                    <td> 	
                        <p>Nombre de places : </p><input type="number" name="nb_places" id="nb_places" value=<?php echo $nb_places; ?>>
                    </td>

                </tr>
                <tr>
                    <td colspan="3">
                        <p>Code promo : </p><input type="text" name="code_promo" value=<?php echo $code_promo; ?>>
                    </td>
                </tr>
            </table>
                <div id = "calcul">
                    <input type="submit" value="Calcul du prix" id="calcul" >
                </div>
            </br>
        </form>

        <?php
            if (!empty($_GET['nom'])
                && !empty($_GET['prenom'])
                && !empty($_GET['date_reservation']) 
                && !empty($_GET['mail'])
                && !empty($_GET['court'])
                && !empty($_GET['zone'])
                && !empty($_GET['datenaiss'])
                && !empty($_GET['nb_places'])){

                    

                    $bdd = Connect_db(); 
                    //S'amuser avec PHP pour tout faire marcher//
                    ?> 
        <?php
            } else {
                ?>
                <p class="echec">Merci de remplir tous les champs avant de calculer le prix</p>
        <?php
            }
        ?>

        <a href="paiement.html"> 
            <input type="submit" value="Payer" id="redirect"> 
        </a>
    </body>
</html>
