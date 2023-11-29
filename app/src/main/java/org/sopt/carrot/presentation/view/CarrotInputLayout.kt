package org.sopt.carrot.presentation.view

import android.content.Context
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.utils.fromDpToPx
import org.sopt.carrot.databinding.CustomViewInputTextBinding

class CarrotInputLayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {
    private lateinit var binding: CustomViewInputTextBinding

    init {
        attributeSet?.let {
            initAttr(attributeSet)
        }
    }

    private fun initAttr(attrs: AttributeSet) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CarrotInputLayout,
            0, 0
        ).apply {
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.custom_view_input_text,
                this@CarrotInputLayout,
                true
            )
            binding.tvTitle.text = getString(R.styleable.CarrotInputLayout_android_text)
            binding.etContent.hint = getString(R.styleable.CarrotInputLayout_android_hint)
            binding.etContent.minimumHeight = getDimensionPixelSize(
                R.styleable.CarrotInputLayout_android_minHeight,
                54.fromDpToPx()
            )
            binding.etContent.filters = arrayOf(
                InputFilter.LengthFilter(
                    (getString(R.styleable.CarrotInputLayout_android_maxLength) ?: "0").toInt()
                )
            )
            recycle()
        }
    }


    fun setCountText(countText: String) {
        binding.tvCount.text = countText
    }

    fun setCountTextColor(countTextColor: Int) {
        binding.tvCount.setTextColor(ContextCompat.getColor(context, countTextColor))
    }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        binding.etContent.addTextChangedListener(textWatcher)
    }
}
