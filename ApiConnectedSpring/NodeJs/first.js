console.log("hello world")


if(true){
    var a=10;
    let b=90;
}

// you will get scope error 
// console.log(a,b)

fetch('http://127.0.0.1:8081/')           //api for the get request
  .then(response => response.json())
  .then(data => console.log(data));