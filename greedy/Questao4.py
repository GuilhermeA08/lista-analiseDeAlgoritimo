def sapoDinamico(pedras):

    vezI = True
    solucao = []

    sapoI = int(pedras[0][2:])  
    sapoV = int(pedras[0][2:])  

    for x in range(1, len(pedras)):

        pedraAtualDist = int(pedras[x][2:])
        pedraAtualTipo = pedras[x][0]

        if pedraAtualTipo == 'S':  

            if vezI:  

                saltoI = abs(pedraAtualDist - sapoI)  
                sapoI = pedraAtualDist  
                solucao.append(saltoI)  

                vezI = False  

            else:  
                saltoJ = abs(pedraAtualDist - sapoV)
                sapoV = pedraAtualDist
                solucao.append(saltoJ)

                vezI = True 

        else:  
            saltoI = abs(pedraAtualDist - sapoI)
            saltoJ = abs(pedraAtualDist - sapoV)
            sapoI = pedraAtualDist
            sapoV = pedraAtualDist
            solucao.append(saltoI)
            solucao.append(saltoJ)

    return max(solucao)

def formataPedras(p, m):

    pedraMargemD = 'B-' + m
    pedraMargemE = 'B-0'

    p.insert(0, pedraMargemE)  
    p.append(pedraMargemD)  

    return p


if __name__ == '__main__':

    casos = int(input())

    for x in range(casos):
        distMargem = input().split()[1]

        pedras = input().split() 

        pedras = formataPedras(pedras, distMargem)

        s = sapoDinamico(pedras)

        print("Case %d: %d" % (x + 1, s))