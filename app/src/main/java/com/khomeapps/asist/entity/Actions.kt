package com.khomeapps.asist.entity

import com.khomeapps.asist.R

/**
 * Created by kubilaay on 2019-09-07.
 */
enum class Actions(val drawableId: Int?, val title: String?, val price: Int?) {
    TOWING(R.drawable.ic_towing_64_px, "Towing & Rescue", 99),
    BREAKDOWN(R.drawable.ic_breakdown_64_px, "Breakdown", 99),
    FLATTIRE(R.drawable.ic_flattire_64_px, "Flat Tire", 99),
    JUMPSTART(R.drawable.ic_jumpstart_64_px, "Jump Start", 99),
    LOCKOUT(R.drawable.ic_lockout_64_px, "Lockout", 99),
    OUTOFGAS(R.drawable.ic_outofgas_64_px, "Out of Gas", 99)
}