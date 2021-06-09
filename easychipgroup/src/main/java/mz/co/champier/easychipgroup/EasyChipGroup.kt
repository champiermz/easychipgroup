package mz.co.champier.easychipgroup

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.ViewCompat
import com.google.android.material.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class EasyChipGroup<T>(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
) : ChipGroup(context, attrs, defStyleAttr) {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        R.attr.chipGroupStyle
    )

    private var data: List<T>? = null
    var onItemClickListener: ((T) -> Unit)? = null
        private set
    private var onBindChip: (Chip, T) -> Unit = { _, _ -> }

    fun submitList(
        data: List<T>,
        onBindChip: (Chip, T) -> Unit
    ) {
        setOnBindChip(onBindChip)
        removeAllViews()
        var chip: Chip
        for (i in data.indices) {
            val element = data[i]
            chip = Chip(context)
            chip.id = ViewCompat.generateViewId()
            chip.setOnClickListener { view ->
                view.isSelected = true
                onItemClickListener?.let { it(element) }
            }
            onBindChip(chip, element)
            addView(chip)
        }
    }

    fun setOnItemClickListener(listener: (T) -> Unit) {
        this.onItemClickListener = listener
        data?.let {
            submitList(it, onBindChip)
        }
    }

    private fun setOnBindChip(onBindChip: (Chip, T) -> Unit) {
        this.onBindChip = onBindChip
        data?.let {
            submitList(it, onBindChip)
        }
    }
}