
const numerosPrimos = () => {

    let primero10Primos = 0;
    let i = 0;
    while (primero10Primos<10) {
        const numeroPrimo = esPrimo(i);
        if(numeroPrimo){
            primero10Primos++;
            console.log("Numero Primo ["+primero10Primos+"] "+i);
        }

        i++;
    }

}

const esPrimo = numero => {


    if(numero == 0 || numero == 1 || numero == 4){
        return false;
    }

    for (let x = 2; x <numero/2; x++) {
        if(numero % x ==0){
            return false;
        }
    }

    return true;
} 


numerosPrimos();