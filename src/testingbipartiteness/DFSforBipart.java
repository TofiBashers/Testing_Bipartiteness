/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingbipartiteness;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author TofixXx
 */
public class DFSforBipart {
    boolean marked[];
    boolean part[];
    boolean isBipart = true;
    HashSet<Integer> AdjList[];
    DFSforBipart(HashSet<Integer> AList[], int V, int E)
    {
        AdjList = AList;
        marked = new boolean[V + 1];
        part = new boolean[V + 1];
        Iterator<Integer> it = AdjList[1].iterator();
        marked[1] = true;
        part[1] = true;
        while(it.hasNext())
        {
            int S = it.next();
            if(!marked[S])
            {
                marked[S] = true;
                part[S] = !part[1];
                search(S);
            }
            if(!isBipart)
            {
                break;
            }
        }
    }
    void search(int V)
    {
        Iterator<Integer> it = AdjList[V].iterator();
        while(it.hasNext())
        {
            int S = it.next();
            if(!marked[S])
            {
                marked[S] = true;
                part[S] = !part[V];
                search(S);
            }
            else if(part[S] == part[V])
            {
                isBipart = false;
            }
            if(!isBipart)
            {
                return;
            }
        }
    }
    public int isBipart()
    {
        if(isBipart)
        {
            return 1;
        }
        return -1;
    }
}
