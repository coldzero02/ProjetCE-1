<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>
	<body >
		<div class="page">
			<div class="entete">
				<div class="logo">				
				</div>
				<ul class ="menu">
					<li>
						<form action="accueilTresorier.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
				        	<button type="submit">Accueil</button>
				        </form>					
					</li>
					<li>
						<form action="infosPersoTresorier.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
				        	<button type="submit" >Infos <br> Personnelles</button>
				        </form>						
					</li>
					<li>
						<form action="modifierMdpTresorier.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
			        		<button type="submit" >Modifier <br> MDP</button>
			        	</form>	
											
					</li>
					<li>
						<form action="accueil.html"" method="post">
				        	<button type="submit" >Quitter</button>
				        </form>						
					</li>	
				</ul>
				
			</div>
			
			<div class="corps-accueil" style="display:${displayCorpsAccueil};">
				<ul class ="menu-accueil">
					<li>
						<form action="saisirPrestations.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
				        	<button type="submit" >Saisir <br> prestations</button>
				        </form>						
					</li>
					<li>
						<form action="consulterBudget.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
			        		<button type="submit" >Consulter <br> budget</button>
			        	</form>											
					</li>
				</ul>					
			</div>
			
			<div class="corps" style="display:${displayCorps};">
				<ul class ="menu-gauche" >
					<li>
						<form action="saisirPrestations.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
				        	<button type="submit" >Saisir <br> prestations</button>
				        </form>						
					</li>
					<li>
						<form action="consulterBudget.html" method="post">
							<input type="hidden" name="id" value = "${user.id}" />
							<input type="hidden" name="bonjour" value = "${bonjour}" />
							<input type="hidden" name="espace" value = "${espace}" />
			        		<button type="submit" >Consulter <br> budget</button>
			        	</form>											
					</li>
				</ul>					
				<div class="coeur" >	
					<div class="infos-perso" style="display:${displayInfosPerso};">	
						<br>
						 <p>informations perso</p>
					</div>	
					<div class="mdp" style="display:${displayMdp};">	
					    <br>
						 <p>Login/mdp</p>	
						 ${ user.password}	
					</div>
					<div class="prestations" style="display:${displayPrestation};">
						<br>	
						 <p>prestations</p>	
					</div>	
					<div class="budget" style="display:${displayBudget};">	
						<br>
						 <p>budget</p>		
					</div>	
				</div>
			</div>
			
			<fieldset style="display:none">
		        <legend>${ espace }</legend>
		        <label for="bonjour">${ bonjour} </label>       
		        <br />
		        <form action="seDeconnecter.html" method="post">
		        	<input type="submit" value="se déconnecter">
		        </form>
				<br />
		    </fieldset>
		</div>
		
	</body>
</html>