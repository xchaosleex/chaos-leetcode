const person = {
    name: 'John',
    position: 'Beijing',
    sayHello: () => {
        console.log(`Hello, I am ${this.name}.`);
    },
    address: {
        sayAddress: () => {
            console.log(`Hello, I in ${this.position}.`);
        }
    }
};

const people = {
    name: 'John',
    sayHello: function () {
        console.log(`Hello, I am ${this.name}.`);
    }
};

person.sayHello(); // Hello, I am undefined.
person.address.sayAddress(); // Hello, I in undefined.
people.sayHello(); // Hello, I am John.

// function regularFunction() {
//     const arrowFunc = () => {
//         console.log(this);
//     };
//     arrowFunc();
// }
// regularFunction();
// regularFunction.call({ a: 1 });
