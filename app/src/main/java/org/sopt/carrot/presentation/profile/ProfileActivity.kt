package org.sopt.carrot.presentation.profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.content.ContextCompat
import org.sopt.carrot.R
import org.sopt.carrot.core.ui.base.BindingActivity
import org.sopt.carrot.databinding.ActivityProfileBinding

class ProfileActivity : BindingActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    private var nicknameCountTextFlag = true
    private var selfIntroduceCountTextFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initCarrotInputLayoutNickname()
        initCarrotInputLayoutSelfIntroduce()
    }

    private fun initCarrotInputLayoutNickname() {
        binding.carrotInputLayoutNickname.setCountText(getString(R.string.text_length12, "0"))
        binding.carrotInputLayoutNickname.run {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    setCountText(getString(R.string.text_length12, p0?.length.toString()))
                    nicknameCountTextFlag = if ((p0?.length ?: 0) > 0) {
                        if (nicknameCountTextFlag) setCountTextColor(R.color.carrot_grey500)
                        if (nicknameCountTextFlag && !selfIntroduceCountTextFlag) {
                            enabledButtonComponent(true, R.color.carrot_white)
                        }
                        false
                    } else {
                        enabledButtonComponent(false, R.color.carrot_grey300)
                        setCountTextColor(R.color.carrot_grey400)
                        true
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }


    private fun initCarrotInputLayoutSelfIntroduce() {
        binding.carrotInputLayoutSelfIntroduce.setCountText(getString(R.string.text_length200, "0"))
        binding.carrotInputLayoutSelfIntroduce.run {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    setCountText(getString(R.string.text_length200, p0?.length.toString()))
                    selfIntroduceCountTextFlag = if ((p0?.length ?: 0) > 0) {
                        if (selfIntroduceCountTextFlag) setCountTextColor(R.color.carrot_grey500)
                        if (selfIntroduceCountTextFlag && !nicknameCountTextFlag) {
                            enabledButtonComponent(true, R.color.carrot_white)
                        }
                        false
                    } else {
                        enabledButtonComponent(false, R.color.carrot_grey400)
                        setCountTextColor(R.color.carrot_grey400)
                        true
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }

    private fun enabledButtonComponent(enabled: Boolean, buttonTextColor: Int) {
        binding.btnJoinMeeting.let {
            it.isEnabled = enabled
            it.setTextColor(ContextCompat.getColor(this, buttonTextColor))
        }
    }
}