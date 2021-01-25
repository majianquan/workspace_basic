function f(){
    console.log(arguments)
    console.log(Array.from(arguments));
}

f(1,2,3,4)