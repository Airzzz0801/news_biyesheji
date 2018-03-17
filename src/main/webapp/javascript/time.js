 function tab(num)
    {
        return num<10 ? ''+num : parseInt(num.toString().charAt(1)) == 0 ? num.toString().charAt(0)+'-' : num.toString().charAt(0)+'-'+num.toString().charAt(1);
    }