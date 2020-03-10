/**
 * MCMXCIV
 */
function romanToInt(str){

    let i=0,sum=0;
    while(i<str.length){
        if(returnValue(str.charAt(i))<returnValue(str.charAt(i+1))){
          let diff = returnValue(str.charAt(i+1)) - returnValue(str.charAt(i));
          sum=sum+diff;
          console.log(i," if=",sum);
          i++;
        }else{
          sum+=returnValue(str.charAt(i));
          console.log(i,"else=",sum);
        }
        
        i++;
    }
  return sum;
}

function returnValue(char){

    switch(char){
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
      default: return -1;
    }

}

console.log(romanToInt("IX"));
