function example() {
    var x = 10;
    if (true) {
        var x = 20; // re-declares and updates x
        console.log(x); // output: 20
    }
    console.log(x); // output: 20
}
example();

function example() {
    let x = 10;
    if (true) {
        let x = 20; // creates a new x variable in the block scope
        console.log(x); // output: 20
    }
    console.log(x); // output: 10
}
example();


function example() {
    const x = 10;
    if (true) {
        const x = 20; // creates a new x variable in the block scope
        console.log(x); // output: 20
    }
    console.log(x); // output: 10
}
example();