#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define MAX_NUMBER 10000

void Eratos_Check(int n, int array[])
{
	array[0] = 0;
	array[1] = 0;
	for (int i = 2; i * i <= n; i++)
	{
		if (array[i] == -1)
		{
			for (int j = i * i; j <= n; j += i)
			{
				array[j] = 0;
			}
		}
	}
}

int main(void)
{
	int M = 0;
	int N = 0;

	scanf("%d", &M);
	scanf("%d", &N);

	int* number_array = (int*) malloc(sizeof(int) * (MAX_NUMBER + 1));
	memset(number_array, -1, sizeof(int) * (MAX_NUMBER + 1));

	Eratos_Check(MAX_NUMBER, number_array);

	int answer = 0;
	int find = 0;
	int min = -1;
	for (int i = M; i <= N; i++)
	{
		if (number_array[i] == -1)
		{
			answer += i;
			if (find == 0) {
				find = 1;
				min = i;
			}
		}
	}

	free(number_array);

	if(min == -1)
		printf("-1\n");
	else
		printf("%d\n%d\n", answer, min);

	return 0;
}