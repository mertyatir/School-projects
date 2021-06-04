# -*- coding: utf-8 -*-
"""
Created on Fri Jan  4 19:09:15 2019

@author: Mert
"""

def isvalid(nucleicacidsequence):
    nucleicacids=["C","G","A","T","U"] 
    if len(nucleicacidsequence)==0:
        return True
    else:
        if nucleicacidsequence[0] in nucleicacids: # This function checks the nucleic acid to find whether they include any capitals than ["C","G","A","T","U"].If they do then nucleic acid is invalid and function returns False.If it does not returned False until the lenght of the given sequence equals to 0, it returns True.
            return isvalid(nucleicacidsequence[1:])
        else:
            return False
        
def DNAorRNA(nucleicacidsequence): #The function marks the sequence ["DNA","RNA","Invalid","Valid"] after checking every nucleotide seperately.If it finds "U" then it marks the sequence as "RNA","T" for "DNA",["C","G","A"] for "Valid" and else "Invalid".
    if len(nucleicacidsequence)==0:
        return "Valid"
    else:
        if nucleicacidsequence[0]=="T" and DNAorRNA(nucleicacidsequence[1:]) in ["Valid","DNA"]: # If a nucleic acid sequence is marked as DNA, then for that nucleotid is to be valid DNA, it should only include other valid nucleotides ["C","G","A"] or the nucleotide "T" again from now on.If it includes a "U" at some point then it is a invalid sequence.
            return "DNA"
        if nucleicacidsequence[0] in ["C","G","A"] and DNAorRNA(nucleicacidsequence[1:]) in ["DNA"]: # If the sequence marked as "DNA" before, after checking the validity of the current nucleotide, it is marked as "DNA" again.
            return "DNA"
        if nucleicacidsequence[0]=="U" and DNAorRNA(nucleicacidsequence[1:]) in ["Valid","RNA"]: 
            return "RNA"
        if nucleicacidsequence[0] in ["C","G","A"] and DNAorRNA(nucleicacidsequence[1:]) in ["RNA"]: 
            return "RNA"
        if nucleicacidsequence[0] in ["C","G","A"] and DNAorRNA(nucleicacidsequence[1:])=="Valid":
            return "Valid"
        else:
            return "Invalid"
def complementary(nucleicacidsequence): # Reads the DNA sequence and returns : "T" for "A","A" for "T","G" for "C" and "C" for "G".It concanates all of this to one string then.
    if len(nucleicacidsequence)==0:
        return ""
    else:
        if nucleicacidsequence[0]=="T": 
            return "A"+complementary(nucleicacidsequence[1:])
        if nucleicacidsequence[0]=="A":
            return "T"+complementary(nucleicacidsequence[1:])
        if nucleicacidsequence[0]=="G":
            return "C"+complementary(nucleicacidsequence[1:])
        if nucleicacidsequence[0]=="C":
            return "G"+complementary(nucleicacidsequence[1:])

        
def numberofdifferences(nucleicacidsequence1,nucleicacidsequence2):    
    if len(nucleicacidsequence1)==0 or len(nucleicacidsequence2)==0: # If one sequence is longer than the other, then all of that excess nucleotides are counted as difference.
            return abs(len(nucleicacidsequence1)-len(nucleicacidsequence2))
    else:
        if nucleicacidsequence1[0]==nucleicacidsequence2[0]:
            return numberofdifferences(nucleicacidsequence1[1:],nucleicacidsequence2[1:])
        else:
            return 1+numberofdifferences(nucleicacidsequence1[1:],nucleicacidsequence2[1:]) # It founds the different pairs and increases difference by 1.
        
def main():
    print(isvalid("AUTCGATUTGC"))
    print(isvalid("ASADGADGAC"))
    print(DNAorRNA("ATGC"))
    print(DNAorRNA("AUGC"))
    print(DNAorRNA("UTGC"))
    print(DNAorRNA("ABC"))
    print(complementary("ATTGCC"))
    print(numberofdifferences("CATCTCG","ACTCAC"))
    print(numberofdifferences("ACTCAC","CATCTCG"))
    
main()
 
    

    