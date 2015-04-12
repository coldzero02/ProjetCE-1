<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE >
<html>
	<head>
		<meta charset="utf-8" />
		<title>Accueil</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>
	<body>
		<div class="page">
			<div class="entete">
				<div class="logo">				
				</div>
			</div>
			<h3 > Accueil </h3>
			
			<form method="post" action="authentification.html">
		        <fieldset>
		            <legend>Se connecter</legend>
		
		            <label for="identifiant">Login <span class="requis">*</span> </label>
		            <input type="text" id="identifiant" name="identifiant" value="" size="20" maxlength="20" />
		            <br />
		            
		            <label for="password">Mot de pass <span class="requis">*</span> </label>
		            <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
		            <br />
		
		            <span class="erreur">${ message }</span>
		            <input type="submit" value="Se connecter"  />
		        	<input type="reset" value="Remettre à zéro" /> <br />
		        </fieldset>
		                      
	        </form>
					
			<form action="nouveauUser.html" method="post">
				<fieldset>
		            <legend>Nouveau compte</legend>
		
		            <label for="nom">Nom <span class="requis">*</span> </label>
		            <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
		            <br />
		            
		            <label for="prenom">Prénom <span class="requis">*</span> </label>
		            <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
		            <br />
		            
		            <label for=fonction>Fonction <span class="requis">*</span> </label>          
		            <select name="fonction" >
						<option value="Tresorier">Tresorier</option>
	                    <option value="Employe">Employé</option>
	                    <option value="Prestataire">Prestataire</option>
	 				</select>
	 				 <br />
	 				 
		            <label for="identifiant">Identifiant <span class="requis">*</span> </label>
		            <input type="text" id="identifiant" name="identifiant" value="" size="20" maxlength="20" />
		            <br />
		            
		            <label for="password">Mot de pass <span class="requis">*</span> </label>
		            <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
		            <br />
		            <span class="${ style_ajout }">${ message_ajout }</span>
	                <input type="submit" value="Valider"  />
		       		<input type="reset" value="Remettre à zéro" /> <br />
		        </fieldset>
		        			
			</form>
			 <!-- <input type="text" value="nom : ${nom}"/> --> 
			 <!-- <input type="text" value="prenom : ${prenom}"/> --> 
			 <!-- <input type="text" value="fonction : ${fonction}"/> --> 
	    </div>
	</body>
</html>