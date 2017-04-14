bool detectCapitalUse(char* word) {
    if(*(word++) < 'a') //首字母大写
    {
        if(*word && *word < 'a') //第二个字母大写
        {
            while(*word)
            {
                if(*(word++) >= 'a') return false;
            }
        }
        else //第二个字母小写
        {
            while(*word)
            {
                if(*(word++) < 'a') return false;
            }
        }
    }
    else //首字母小写
    {
        while(*word)
        {
            if(*(word++) < 'a') return false;
        }
    }
    return true;
}
