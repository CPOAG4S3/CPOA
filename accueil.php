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
				<td><p>Date : </p><input type="date" name="date_reservation"/>
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
					<p>Prénom : </p> <input type="text" name="prenom" />
				</td>
				<td> 
					<p> Court : </p><input type="text" name="court" />
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
					<p>Mail : </p><input type="text" name="mail" /></tr>
				</td>

			

			<tr>
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
			</datalist>
			</tr>
			<tr><p>Nombre de places : </p><input type="text" name="nb_places" /></tr>
			</td>
		</table>
		<input type="submit" value="Envoyer">
	</form>
</body>
</html>


<!-->		<td> 
				<img src="/images/plan_court.jpg" alt="Plan des courts" style="width:128px;height:128px;"> 
			</td>
<!-->
