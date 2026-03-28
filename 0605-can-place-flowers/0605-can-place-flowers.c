bool canPlaceFlowers(int* flowerbed, int flowerbedSize, int n) {

    for(int i=0;i<flowerbedSize;i++)
    {
        if(n>0)
        {
            if(flowerbed[i]==0)
            {
                if ((i == 0 || flowerbed[i-1] == 0) && 
    (i == flowerbedSize-1 || flowerbed[i+1] == 0))
                {
                    flowerbed[i]=1;
                    n--;
                    i++;
                 }
            }
        }
        else
        {
             break;
        }
    }
    if(n==0)
    {
        return true;
    }
    return false;
}