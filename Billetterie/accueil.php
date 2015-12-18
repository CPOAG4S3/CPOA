<?php
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
</head>


<body>
	<form method="get" action="accueil.php" id = "formulaire">
		<table style="width:100%">
			<tr> 
				<td> 
					<p>Nom : </p><input type="text" name="nom" />
				</td> 	
				<td rowspan=4> <div align = "center">	
                                    <img src="./images/plan_court.jpg" alt="Plan des courts" style="width:30vw;height:auto;"> 
                                </div>
                </td>				
				<td>
					<p>Date : </p><input type="date" name="date_reservation"/>
				</td>			
			</tr>

			<tr> 
				<td> 
					<p>Prénom : </p> <input type="text" name="prenom" />
				</td>
				<td> 
					<p> Court : </p>
					<select name="Court" form = "formulaire">
					<option value = "Court1"> Court 1 </option>
					<option value = "Court2"> Court 2 </option>
					<option value = "Court3"> Court 3 </option>
					<option value = "Court4"> Court 4 </option>
					<option value = "Court5"> Court 5 </option>
					<option value = "Court6"> Court 6 </option> 
				</td>
			</tr>		
			
			
			<tr> 
				<td>
					<p>Date de naissance : </p> <input type="date" name="datenaiss" />
				</td>								
				<td> 
					<p> Zone : </p>
					<select name="Zone" form = "formulaire" >
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
				</td>
			</tr>	
				
				
			<tr>	
				<td> 
					<p>Mail : </p><input type="email" name="mail" />
				</td>
				<td> 	
					<p>Nombre de places : </p><input type="number" name="nb_places" />
				</td>
				
			</tr>
		</table>
		<div align = "center">
            <input type="submit" value="Calcul du prix" id="calcul" > 
        </div>
        </br>
	</form>

	<?php
	// test tous les champs sont rensignés
	if (
		!empty($_GET['nom']) 
		&& !empty($_GET['prenom']) 		 
		&& !empty($_GET['naissance']) 
		&& !empty($_GET['mail']) 
		&& !empty($_GET['date']) 
		&& !empty($_GET['court'])
		&& !empty($_GET['zone']) 
		&& !empty($_GET['nbplace']) 		
		
	){
					
			$nom = $_GET['nom'];
			$prenom = $_POST['prenom'];	
			$email = $_POST['email'];			
			$naissance = $_GET['naissance'];
			$date = $_GET['date'];
			$court = $_GET['court'];
			$zone = $_GET['zone'];
			$nbplace = $_GET['nbplace'];
						
			$bdd = Connect_db(); 	
	?>
	
    <a href="paiement.html" style="padding-left:47.5vw;padding-right:auto;"> 
        <input type="submit" value="Payer" id="redirect"> 
    </a>
</body>
</html>
