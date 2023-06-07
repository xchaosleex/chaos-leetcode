let symbol1 = Symbol();

let obj = {
    [symbol1]: "value"
};

console.log(obj[symbol1]);  // "value"
console.log(symbol1)

let symbol2 = Symbol("symbol1");
let symbol3 = Symbol("symbol1");

console.log(symbol2 === symbol3);  // false
console.log(symbol2)
console.log(symbol3)


obj = {
    first: "Kyle",
    last: "Simpson",
    age: 39,
    specialties: ["JS", "Table Tennis"]
};
console.log(`My name is ${obj.first}, my specialties is ${obj.specialties}`);

console.log(typeof Symbol("CHAOX"));
console.log(typeof undefined);
console.log(typeof null);
console.log(typeof 11111111111111111111n);
console.log(typeof "null");
console.log(typeof { "a": 1 });
console.log(typeof function hello() { });

console.log("--------------------------")


const actors = ["Morgan Freeman", "Jennifer Aniston"];
actors[2] = "Tom Cruise"; // OK :(
console.log(actors); // output: ["Morgan Freeman", "Jennifer Aniston", "Tom Cruise"]
// actors = []; // Error!


try {
    const re = 1 / 0;
    console.log(re);
    console.log(typeof re);
    re = 1;
}
catch (err) {
    console.log(err);
}

// const re = 1 / 0;
// console.log(re);
// console.log(typeof re);
// re = 1;