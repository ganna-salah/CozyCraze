
// Accordion
function myAccFunc(acc) {
  var x = document.getElementById(acc);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}

// Click on the "Jeans" link on page load to open the accordion for demo purposes
document.getElementById("myBtn").click();

// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

function decideImage(x) {
  switch (x) {
    case "pocketless hoddie":
      document.getElementById("design_image").src =
        "products/pocketlessHoodie.png";
      break;
    case "pocketed hoddie":
      document.getElementById("design_image").src =
        "products/pocketed hoodie.png";
      break;
    case "Sweatshirt":
      document.getElementById("design_image").src =
        "products/sweatshirt copy.png";
      break;
    case "sweatpants":
      document.getElementById("design_image").src =
        "products/sweatpants.png";
      break;
    case "wideLeg":
      document.getElementById("design_image").src =
        "products/wide leg copy.png";
      break;
    case "shortShirt":
      document.getElementById("design_image").src =
        "products/tshirt copy.png";
      break;
    case "longShirt":
      document.getElementById("design_image").src =
        "products/long sleeve shirt.png";
      break;
    case "jacket":
      document.getElementById("design_image").src =
        "products/jacket.png";
      break;

    case "sports jacket":
      document.getElementById("design_image").src =
        "products/sports jacket.png";
      break;

    case "pocketed sweatshirt":
      document.getElementById("design_image").src =
        "products/pocket sweatshirt.png";
      break;
  }
}

function decideColor(color) {
  switch (color) {
    case "black":
      document.getElementById("design_image").style.backgroundColor =
        "black";
      break;
    case "pink":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(237,170,173)";
      break;
    case "white":
      document.getElementById("design_image").style.backgroundColor =
        "white";
      break;
    case "blue":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(6,66,165)";
      break;
    case "red":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(189,43,69)";
      break;
    case "green":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(0,113,114)";
      break;
    case "purple":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(132,65,128)";
      break;
    case "grey":
      document.getElementById("design_image").style.backgroundColor =
        "rgb(128,128,128)";
      break;
    case "pistachio":
      document.getElementById("design_image").style.backgroundColor =
        "#93C572";
      break;
    case "Saffron":
      document.getElementById("design_image").style.backgroundColor =
        "#F4C430";
      break;
    case "chocolate":
      document.getElementById("design_image").style.backgroundColor =
        "#7B3F00";
      break;
    case "beige":
      document.getElementById("design_image").style.backgroundColor =
        "#f6ecc0";
      break;
  }
}

// drag and drop funtions

function allowDrop(ev) {
    ev.preventDefault();
  }

  function drag(ev) {
    ev.dataTransfer.setDragImage(ev.target, 0, 0); // Set the dragged image
    ev.dataTransfer.setData("text", ev.target.id); // Set the ID of the dragged element
  }
  function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    var originalElement = document.getElementById(data);

    // Create a copy of the original element
    var clonedElement = originalElement.cloneNode(true);

    // Set a new ID for the cloned element (optional)
    var newId = "drag" + new Date().getTime();
    clonedElement.id = newId;

    // Append the cloned element to the drop target
    ev.target.appendChild(clonedElement);

    // Make the cloned element draggable within the div
    var draggableInstance = new Draggabilly(clonedElement, {
      containment: "#div3",
    });
  }
  function removeContent() {
    // Get the reference to the div
    var myDiv = document.getElementById("div3");

    // Remove all child nodes (content) from the div
    while (myDiv.firstChild) {
      myDiv.removeChild(myDiv.firstChild);
    }
  }
  
 