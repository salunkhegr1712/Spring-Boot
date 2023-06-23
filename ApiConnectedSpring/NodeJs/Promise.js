function getData(){

    // we are passing a promise 
    return new Promise((resolve,reject)=>{

        setTimeout(()=>{

            if(true){
                resolve([
                    {name:"ghansham",mis:111},
                    {name:"abhi",mis:102}
                ])
            }
            else{
                reject(
                    "failed to fetch  the data"
                )
            }
        },3000)

    })
}

// so now lets grab that data 

const responce=getData()

// after we can fetch on promise using the then 
responce.then(onResolved,onRejected)
// if resolved the onResolved function is called
// if rejected the on onRejected function is called

function onResolved(){
    // print the content of responce promise
    console.log(responce);
}

function onRejected(){
    console.log("we failed to fetch the data")
}


// lets try to get the data from the our rest api build on top of the spring application 