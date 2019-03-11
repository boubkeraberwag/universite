console.log("JS chargé!");

function validerLeFormulaire() {
    let gradeElement =
        document.getElementById("grade");
    let grade = gradeElement.value;

    if(grade == "" || grade.length > 3){
        console.log("Grade non valide");
        gradeElement.classList.add("erreur");
    }else{
    	gradeElement.classList.remove("erreur");
    }


    let nomElement = document.getElementById("nom");
    let nom = nomElement.value;
    if(nom === ""){
        nomElement.classList.add("erreur");
    }else{
        nomElement.classList.remove("erreur");
    }

    // check prenom
    let prenomBlock =
        document.getElementById("prenom");
    let prenom = prenomBlock.value

    if(prenom === ""){
        prenomBlock.classList.add("erreur");
    }else{
        prenomBlock.classList.remove("erreur");
    }
    
 // check numero
    let numeroBlock =
        document.getElementById("numero");
    let numero = numeroBlock.value

    if(numero === ""){
    	numeroBlock.classList.add("erreur");
    }else{
    	numeroBlock.classList.remove("erreur");
    }
    
    // check dateNaissance
    let dateNiassanceBlock = 
    	document.getElementById("dateNaissance");
    let dateNaissance = dateNiassanceBlock.value;
    
    if(dateNaissance === ""){
    	dateNiassanceBlock.classList.add("erreur");
    }else{
    	dateNiassanceBlock.classList.remove("erreur");
    }
    
    // check dateNaissance
    let dateEmbaucheBlock = 
    	document.getElementById("dateEmbauche");
    let dateEmbauche = dateEmbaucheBlock.value;
    
    if(dateEmbauche === ""){
    	dateEmbaucheBlock.classList.add("erreur");
    }else{
    	dateEmbaucheBlock.classList.remove("erreur");
    }
    
 // check Photo
    let photoBlock = 
    	document.getElementById("photo");
    let photo = photoBlock.value;
    
    if(photo === ""){
    	photoBlock.classList.add("erreur");
    }else{
    	photoBlock.classList.remove("erreur");
    }

    let lesClassErreur = document.getElementsByClassName("erreur");
    console.log(lesClassErreur);
    console.log("taille du tableau " + lesClassErreur.length);
    
    if(lesClassErreur.length === 0){
    	// envoyer le formulaire
    	console.log("Envoyer le formulaire");
    	
    	document.getElementById("formulaire").submit();
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
    
}