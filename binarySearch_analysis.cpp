#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
using namespace std;

int stepCount=0;
int recursiveBinarySearch(vector<int>& arr,int left,int right,int target){
    stepCount++;
    if(left<=right){
        int mid=left+(right-left)/2;
        if(arr[mid]==target)return mid;
        else if(arr[mid]>target)return recursiveBinarySearch(arr,left,mid-1,target);
        else return recursiveBinarySearch(arr,mid+1,right,target);
    }
    return -1;
}

void analyzbinarysearchRecursive(){
    vector<int> inputSizes={10,20,30,40,50,100};
    for(int i=0;i<inputSizes.size();i++){
        int size=inputSizes[i];
        vector<int> arr(size);
        for(int i=0;i<size;i++){
            arr[i]=i+1; 
        }
    // cout<<"Array: [ ";
    // for(int i=0;i<size;i++){
    //     cout<<arr[i]<<" ";
    // }cout<<"]"<<endl;

    int bestcase=arr[(size-1)/2];
    int worstcase=arr[size-1];
    srand(time(0));
    int randomindex=rand()%size;
    int randomcase=arr[randomindex];

    cout<<"=================== Input Size: "<<size<<" ==================="<<endl;
    stepCount=0;
    recursiveBinarySearch(arr,0,size-1,bestcase);
    cout<<"Best Case= "<<stepCount<<" steps"<<endl;
    stepCount=0;
    recursiveBinarySearch(arr,0,size-1,randomcase);
    cout<<"Average Case= "<<stepCount<<" steps"<<endl;
    stepCount=0;
    recursiveBinarySearch(arr,0,size-1,worstcase);
    cout<<"Worst Case= "<<stepCount<<" steps"<<endl;
    cout<<"==================================================================="<<endl<<endl;
    }
}

int main(){
    analyzbinarysearchRecursive();
    return 0;
}



