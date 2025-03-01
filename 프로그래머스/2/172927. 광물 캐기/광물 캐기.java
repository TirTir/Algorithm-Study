import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2]; // 사용 가능한 총 곡괭이 개수
        int len = Math.min(minerals.length, totalPicks * 5); // 캘 수 있는 광물 수 제한
        List<int[]> groups = new ArrayList<>(); // 각 그룹별 피로도 저장

        // 광물을 5개씩 그룹화하여 피로도 계산
        for (int i = 0; i < len; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < len; j++) {
                if (minerals[j].equals("diamond")) {
                    dia++;
                } else if (minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }
            // 그룹별 광물 수 저장
            groups.add(new int[]{dia, iron, stone});
        }

        // **중요한 그룹을 먼저 캘 수 있도록 정렬** (다이아가 많은 순서 → 철 → 돌)
        Collections.sort(groups, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // 다이아몬드 개수 기준 정렬
            if (a[1] != b[1]) return b[1] - a[1]; // 철 개수 기준 정렬
            return b[2] - a[2]; // 돌 개수 기준 정렬
        });

        int fatigue = 0; // 총 피로도
        for (int[] group : groups) {
            if (picks[0] > 0) { // 다이아몬드 곡괭이 사용 가능
                fatigue += group[0] + group[1] + group[2]; // 모든 광물을 피로도 1로 캔다.
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이 사용 가능
                fatigue += group[0] * 5 + group[1] + group[2]; // 다이아는 5, 나머지는 1
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이 사용 가능
                fatigue += group[0] * 25 + group[1] * 5 + group[2]; // 다이아 25, 철 5, 돌 1
                picks[2]--;
            } else {
                break; // 곡괭이 소진 시 종료
            }
        }

        return fatigue;
    }
}
