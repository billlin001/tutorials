package com.baeldung.peakelements;

import java.util.ArrayList;
import java.util.List;

public class PeakElementFinder {
    public List<Integer> findPeakElement(int[] arr) {
        int n = arr.length;
        List<Integer> peaks = new ArrayList<>();

        if (n == 0) {
            return peaks;
        }

        for (int i = 0; i < n; i++) {
            if (isPeak(arr, i, n)) {
                peaks.add(i);
            }
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
        }

        return peaks;
    }

    private boolean isPeak(int[] arr, int index, int n) {

        if (index == 0) {
            return n > 1 ? arr[index] >= arr[index + 1] : true;
        } else if (index == n - 1) {
            return arr[index] >= arr[index - 1];
        }

        return arr[index] >= arr[index - 1] && arr[index] >= arr[index + 1];
    }
}

